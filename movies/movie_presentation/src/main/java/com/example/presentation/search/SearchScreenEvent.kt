package com.example.presentation.search

sealed class SearchScreenEvent() {
    object OnSearchMovieCategorySelect:SearchScreenEvent()
    object OnSearchSeriesCategorySelect:SearchScreenEvent()
    object OnSearchActorCategorySelect:SearchScreenEvent()
    object OnSearchClick:SearchScreenEvent()

    class OnSearchTextChange(val text:String):SearchScreenEvent()
}