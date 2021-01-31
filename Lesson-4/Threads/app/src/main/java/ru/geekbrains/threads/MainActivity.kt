package ru.geekbrains.threads

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    var counterThread = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtonThreadWithHandler()
        initButtonThreadWithActivity()
        initButtonThreadWithView()
        initButtonHandlerThread()
    }

    private fun initButtonThreadWithHandler() {
        buttonThreadWithHandler.setOnClickListener {
            counterThread++
            val numberThread = counterThread
            textResult.text = "${textResult.text}Run thread (return from handler) $numberThread\n"
            val handler = Handler(Looper.myLooper()!!)
            thread {
                handler.post {
                    textResult.text =
                        "${textResult.text}Start thread (return from handler) $numberThread\n"
                }
                calculate(editDelay.text.toString().toLong())
                handler.post {
                    textResult.text =
                        "${textResult.text}Finish thread (return from handler) $numberThread\n"
                }
            }
        }
    }

    private fun initButtonThreadWithActivity() {
        buttonThreadWithActivity.setOnClickListener {
            counterThread++
            val numberThread = counterThread
            textResult.text =
                "${textResult.text}Run thread (return from activity) $numberThread\n"
            thread {
                MainActivity@ this.runOnUiThread {
                    textResult.text =
                        "${textResult.text}Start thread (return from activity) $numberThread\n"
                }
                calculate(editDelay.text.toString().toLong())
                MainActivity@ this.runOnUiThread {
                    textResult.text =
                        "${textResult.text}Finish thread (return from activity) $numberThread\n"
                }
            }
        }
    }

    private fun initButtonThreadWithView() {
        buttonThreadWithView.setOnClickListener {
            counterThread++
            val numberThread = counterThread
            textResult.text = "${textResult.text}Run thread (return from view) $numberThread\n"
            thread {
                textResult.post {
                    textResult.text =
                        "${textResult.text}Start thread (return from view) $numberThread\n"
                }
                calculate(editDelay.text.toString().toLong())
                textResult.post {
                    textResult.text =
                        "${textResult.text}Finish thread (return from view) $numberThread\n"
                }
            }
        }
    }

    private fun initButtonHandlerThread(){
        val handlerThread = HandlerThread("MyHandler")
        handlerThread.start();
        val handler = Handler(handlerThread.looper);

        buttonHandlerThread.setOnClickListener {
            counterThread++
            val numberThread = counterThread
            textResult.text = "${textResult.text}Run handler thread (HandlerThread) $numberThread\n"
            handler.post {
                textResult.post {
                    textResult.text =
                        "${textResult.text}Start handler thread (HandlerThread) $numberThread\n"
                }
                calculate(editDelay.text.toString().toLong())
                textResult.post {
                    textResult.text =
                        "${textResult.text}Finish handler thread (HandlerThread) $numberThread\n"
                }
            }
        }
    }

    private fun calculate(delaySeconds: Long) {
        val date = Date()
        var diffInSec: Long
        do {
            diffInSec = Date().run {
                val diffInMs = time - date.time
                TimeUnit.MILLISECONDS.toSeconds(diffInMs)
            }
        } while (diffInSec < delaySeconds)
    }
}