package com.yinghao.domain.wechat.resp;

/**
 * 音乐消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class MusicMessage extends PlatformBaseMessage {

    private Music Music;// 音乐

    public Music getMusic() { return Music; }
    public void setMusic(Music music) { Music = music; }
}
