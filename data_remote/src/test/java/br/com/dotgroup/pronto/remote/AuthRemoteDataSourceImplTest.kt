package br.com.dotgroup.pronto.remote

//import br.com.dotgroup.pronto.remote.test.DataFactory
//import br.com.dotgroup.pronto.remote.test.RemoteDataFactory
//import com.matheusbrandao.pokemon.data_remote.ApiRemoteDataSourceImpl
//import com.matheusbrandao.pokemon.data_remote.model.PokemonDataEntity
//import com.matheusbrandao.pokemon.data_remote.model.PokemonInfoDataEntity
//import com.matheusbrandao.pokemon.data_remote.net.service.ApiService
//import com.nhaarman.mockito_kotlin.any
//import com.nhaarman.mockito_kotlin.mock
//import com.nhaarman.mockito_kotlin.verify
//import com.nhaarman.mockito_kotlin.whenever
//import io.reactivex.Observable
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.junit.runners.JUnit4

//@RunWith(JUnit4::class)
//class AuthRemoteDataSourceImplTest {
//
//    private val service = mock<ApiService>()
//    private val remote = ApiRemoteDataSourceImpl(service)

//    @Test
//    fun should_Complete_When_RegisterUserIsCalled() {
//        stubAuthServiceRegisterUser(
//            Observable.just(RemoteDataFactory.makeResponseEntity())
//        )
//        val testObserver = remote.registerUser(
//            // Nos parâmetros abaixo, no exemplo era utilizado any(), mas aqui não funcionou
//            DataFactory.randomString(),
//            DataFactory.randomString(),
//            DataFactory.randomString(),
//            DataFactory.randomString()
//        ).test()
//        testObserver.assertComplete()
//    }

//    @Test
//    fun should_CallServer_When_FetchPokemonsIsCalled() {
//        stubAuthServiceRegisterUser(
//            Observable.just(RemoteDataFactory.makeResponseEntity())
//        )
//        remote.fetchPokemonDetails(
//            DataFactory.randomString()
//        ).test()
//        verify(service).fetchPokemonDetails(any())
//    }

//    @Test
//    fun should_ReturnsData_When_RegisterUserIsCalled() {
//        val remoteResponseEntity = RemoteDataFactory.makeResponseEntity()
//        stubAuthServiceRegisterUser(
//            Observable.just(remoteResponseEntity)
//        )
//
//        val testObserver = remote.registerUser(
//            // Nos parâmetros abaixo, no exemplo era utilizado any(), mas aqui não funcionou
//            DataFactory.randomString(),
//            DataFactory.randomString(),
//            DataFactory.randomString(),
//            DataFactory.randomString()
//        ).test()
//        testObserver.assertValue { result ->
//            result == remoteResponseEntity.responseSuccess!!.message
//        }
//    }

    // Helper
//    private fun stubAuthServiceRegisterUser(observable: Observable<PokemonInfoDataEntity>) {
//        whenever(service.fetchPokemonDetails(any())).thenReturn(observable)
//    }
//}
