package com.example.companyaplication

data class LoadingState<T>(val state: State,val data: T?,val error: String?){

    companion object{
        fun <T> loading(): LoadingState<T>{
           return LoadingState(State.LOADING,null,null)
        }

        fun <T> error(msg: String?):LoadingState<T>{
            return LoadingState(State.ERROR,null,msg)
        }

        fun <T> success(data:T?): LoadingState<T>{
            return LoadingState(State.SUCCESS,data,null)
        }
    }

}

enum class State {
    SUCCESS,
    ERROR,
    LOADING
}
