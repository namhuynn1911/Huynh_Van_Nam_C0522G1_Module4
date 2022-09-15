package music_player.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {

    @Id
    private int id;
    private String musicName;
    private String singerName;
    private String kindOfMusic;
    private String linkMusic;

    public Music() {
    }

    public Music(int id, String musicName, String singerName, String kindOfMusic, String linkMusic) {
        this.id = id;
        this.musicName = musicName;
        this.singerName = singerName;
        this.kindOfMusic = kindOfMusic;
        this.linkMusic = linkMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getLinkMusic() {
        return linkMusic;
    }

    public void setLinkMusic(String linkMusic) {
        this.linkMusic = linkMusic;
    }
}
