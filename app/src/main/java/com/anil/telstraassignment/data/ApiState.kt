package com.anil.telstraassignment.data

sealed class ApiState {
    data class LOADING(val isPullRequest : Boolean) : ApiState()
    object ERROR : ApiState()
    object SUCCESS : ApiState()
}