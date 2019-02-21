package com.michaeljordanr.movilenext3dagger2

import javax.inject.Inject
import javax.inject.Singleton

class Main {
    fun main() {
        val client = OkHttpClient()
        val user = "Paulo Salvatore"
        val twitterApi = TwitterApi(client)

        val tweeter = Tweeter(twitterApi, user)
        tweeter.tweet("Kotlin > Java")
        val timeline = Timeline(twitterApi, user)

        timeline.loadPosts()
    }
}

class Tweeter(
    private val twitterApi: TwitterApi,
    private val user: String
) {
    fun tweet(tweet: String) {
        twitterApi.postTweet(user, tweet)
    }
}

class Timeline(
    private val twitterApi: TwitterApi,
    private val user: String
) {
    fun loadPosts() {
        twitterApi.loadTimeline(user)
    }
}

@Singleton
class TwitterApi @Inject constructor(private val client: OkHttpClient) {
    fun postTweet(user: String, tweet: String) {
        client.request("$user/$tweet")
    }

    fun loadTimeline(user: String) {
    }
}

class OkHttpClient {
    fun request(url: String) {
        // Build a request
    }
}
