package ru.geekbrains.aidlservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val ACTION_AIDL = "ru.geekbrains.aidlservice.IAidlFibo"

    private var aidlFiboService: IAidlFibo? = null

    var serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            // приводим IBinder к нужному нам типу через Stub реализацию интерфейса
            aidlFiboService = IAidlFibo.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            aidlFiboService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(ACTION_AIDL)
        val updatedIntent: Intent = createExplicitIntent(this, intent)
        bindService(updatedIntent, serviceConnection, Context.BIND_AUTO_CREATE)

        button.setOnClickListener {
            val param = editParam.text.toString().toLong()
            val fibo: Long = aidlFiboService!!.calculate(param)
            textResult.text = fibo.toString()
        }
    }

    fun createExplicitIntent(context: Context, intent: Intent): Intent {
        // Получить все службы, которые могут соответствовать указанному Intent
        val pm: PackageManager = context.packageManager
        val resolveInfo = pm.queryIntentServices(intent, 0)

        // Список найденных служб по интенту должен содержать лишь 1 элемент
        if (resolveInfo.size != 1) {
            // иначе служба на "приложении-сервере" не запущена
            throw ExceptionInInitializerError()
        }
        // Получаем информацию о компоненте и создаем ComponentName для Intent
        val serviceInfo = resolveInfo[0]
        val packageName = serviceInfo.serviceInfo.packageName
        val className = serviceInfo.serviceInfo.name
        val component = ComponentName(packageName, className)

        // Повторно используем старый интент
        val explicitIntent = Intent(intent)
        // явно задаем компонент для обработки Intent
        explicitIntent.component = component
        return explicitIntent
    }
}