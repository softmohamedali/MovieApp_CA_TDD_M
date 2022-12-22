package com.example.data.mapper

import com.example.data.remote.dto.actors.RemoteOneActor
import com.example.data.remote.dto.vedio.RemoteVideo
import com.example.domin.models.ActorItem
import com.example.domin.models.Video

fun RemoteVideo.toVideo(): Video {
    return Video(
        id=this.id,
        iso31661=this.iso31661,
        iso6391=this.iso6391,
        key=this.key,
        name=this.name,
        site=this.site,
        size=this.size,
        type=this.type
    )
}

fun List<RemoteVideo>.toListVideo(): List<Video> {
    return this.map { it.toVideo() }
}