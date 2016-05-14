package org.xxx.web.action;

import java.util.ArrayList;
import java.util.List;

import org.xxx.model.entity.Music;
import org.xxx.model.service.MusicService;


public class DemoAction_4 {
	private List<Music> mlist = new ArrayList<Music>();
	private Music music = new Music();

	public List<Music> getMlist() {
		return mlist;
	}

	public void setMlist(List<Music> mlist) {
		this.mlist = mlist;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
	public String find(){
		MusicService service = new MusicService();
		 try {
			mlist = service.find();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "find";
	}
	
	public String findbyid() throws Exception{
		MusicService service = new MusicService();
		System.out.print(music.getId());
		music = service.findById(music.getId());
		return "findbyid";
		
	}
	public String delete() throws Exception{
		MusicService service = new MusicService();
		if(service.delete(music.getId())){
			return "delete";
		}else {
			return "sorry";
		}
		
	}
	public String update() throws Exception{
		MusicService service = new MusicService();
		if(service.update(music)){
			return "update";
		}else {
			return "sorry";
		}
	}
	public String add(){
		return "add";
	}

}
