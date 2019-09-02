package com.anil.telstraassignment.data

sealed class ApiState {
    object LOADING : ApiState()
    object ERROR : ApiState()
    object SUCCESS : ApiState()
}