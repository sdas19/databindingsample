package com.example.databindingsample

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

//data class User(@Bindable var name: String, @Bindable var email: String) : BaseObservable()

data class User(var name: String, var email: String)