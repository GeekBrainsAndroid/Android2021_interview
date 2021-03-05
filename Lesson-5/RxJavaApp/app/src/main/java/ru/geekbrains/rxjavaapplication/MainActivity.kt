package ru.geekbrains.rxjavaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observer = object : Observer<Int> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: Int?) {
                textNaturalRow.text = t.toString()
            }

            override fun onError(e: Throwable?) {
            }

        }

        buttonNaturalRow.setOnClickListener {
            val producer = ProducerNaturalRow()
            producer.run()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)
        }

        val producerFibonacci = ProducerFibonacci()
        buttonFibonachi.setOnClickListener {
            producerFibonacci.run()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        textFibonachi.text = it.toString()
                    }
        }

        buttonEvennumbers.setOnClickListener {
            val producerEvenNumber = ProducerEvenNumber()
            producerEvenNumber.run()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        textEvenNumbers.text = it.toString()
                    }
        }

        buttonCompletable.setOnClickListener {
            textCompletable.text = ""
            val producerCompletable = ProducerCompletable()
            producerCompletable.run()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        textCompletable.text = "Complete!"
                    }, {
                        textCompletable.text = "Error!"
                    })
        }

        buttonSingle.setOnClickListener {
            val producerSingle = ProducerSingle();
            producerSingle.run()
                    .map {
                        UserView(it.firstName, it.secondName)
                    }
                    .subscribe({
                        textName.text = it.name
                        textSurname.text = it.surname
                    }, {
                        textName.text = "Error!"
                        textSurname.text = "Error!"
                    })
        }

        buttonMaybe.setOnClickListener {
            val producerMaybe = ProducerMaybe();
            producerMaybe.run()
                    .subscribe({
                        textMaybe.text = it
                    }, {
                        textMaybe.text = "Error!"
                    }, {
                        textMaybe.text = "Complete!"
                    })
        }

        buttonOddnumber.setOnClickListener {
            val producerOddNumber = ProducerOddNumber()
            producerOddNumber.run()
                    .subscribeOn(Schedulers.computation())
                    .flatMap {
                        return@flatMap Observable
                                .just(it)
                                .delay(Random.nextLong(3_000), TimeUnit.MILLISECONDS)
                                .mergeWith(Observable.just<Long>(0)
                                        .delay(Random.nextLong(3_000), TimeUnit.MILLISECONDS))
                    }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        textOddnumber.text = it.toString()
                    }
        }

        val compositeDisposable = CompositeDisposable()
        var subscriber1: Disposable? = null
        var subscriber2: Disposable? = null
        val producerHot = ProducerHot()
        val hotObservable = producerHot.run()
        hotObservable.connect()
        buttonHot.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                subscriber1 = hotObservable
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            textHot1.text = it.toString()
                        }
                subscriber2 = hotObservable
                        .delay(1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            textHot2.text = it.toString()
                        }
                compositeDisposable.addAll(subscriber1, subscriber2)
            } else {
                compositeDisposable.clear()
            }
        }
    }
}