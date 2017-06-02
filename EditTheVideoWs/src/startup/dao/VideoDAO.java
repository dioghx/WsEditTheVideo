package startup.dao;

import java.util.List;

import startup.model.Video;

public interface VideoDAO {

	 Video create(Video pVideo);

	    Video recovery(int pId);

	    Video update(Video pVideo);

	    boolean delete(int pId);

	    List<Video> search();
}
