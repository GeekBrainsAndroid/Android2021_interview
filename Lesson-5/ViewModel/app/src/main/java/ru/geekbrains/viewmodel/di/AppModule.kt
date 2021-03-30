package ru.geekbrains.viewmodel.di

import org.koin.dsl.module
import ru.geekbrains.viewmodel.network.CbrDaily
import ru.geekbrains.viewmodel.network.RetrofitClient
import ru.geekbrains.viewmodel.repository.IRepositoryCbr
import ru.geekbrains.viewmodel.repository.RepositoryNetwork
import ru.geekbrains.viewmodel.ui.main.MainViewModel


val appModule = module {
    single { MainViewModel(get()) }
    single<CbrDaily> { RetrofitClient.getCbrDaily() }
    factory<IRepositoryCbr> { RepositoryNetwork(get()) }
}