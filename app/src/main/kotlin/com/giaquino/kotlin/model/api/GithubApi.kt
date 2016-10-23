package com.giaquino.kotlin.model.api

import com.giaquino.kotlin.model.entity.User
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * @author Gian Darren Aquino
 */
interface GithubApi {

    @GET("repos/{owner}/{repos}/contributors") fun getContributors(
        @Path("owner") owner: String,
        @Path("repos") repos: String): Observable<List<User>>
}
