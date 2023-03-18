package com.example.domin.usecases.persisitence

import com.example.core.domain.utils.log
import com.example.domin.models.Series
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
@ViewModelScoped
class IsFavSeriesUseCase @Inject constructor(
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
         id:Int
    )= flow{
        moviesRepository.getFavSeries().collect{
            var isfavSeries=false
            it.forEach {
                if (it.id==id){
                    isfavSeries=true
                }
            }
            emit(isfavSeries)
        }
    }

}