package com.anil.telstraassignment

import com.anil.telstraassignment.data.ItemAboutCanada
import com.anil.telstraassignment.network.ApiInterface
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AboutCanadaRepositoryTest {

    @Mock
    private lateinit var api: ApiInterface

    @Test
    fun testApiDataSuccess() {

        val responseObject = ItemAboutCanada()

        Mockito.`when`(api.getAboutCanadaData()).thenReturn(Observable.just(responseObject))

        val testObserver = TestObserver<ItemAboutCanada>()

        val result = api.getAboutCanadaData()
        result.subscribe(testObserver)
        testObserver.assertComplete()
    }

    @Test
    fun testApiDataError() {
        val error = Exception()

        Mockito.`when`(api.getAboutCanadaData()).thenReturn(Observable.error(error))

        val testObserver = TestObserver<ItemAboutCanada>()

        val result = api.getAboutCanadaData()
        result.subscribe(testObserver)
        testObserver.assertError(error)
    }
}