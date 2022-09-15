package music_player.repository;

import music_player.model.Music;

import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(Music music);

    void remove(int id);

}
