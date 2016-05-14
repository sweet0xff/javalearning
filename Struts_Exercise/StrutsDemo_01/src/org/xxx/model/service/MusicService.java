package org.xxx.model.service;

import java.util.List;

import org.xxx.model.dao.MusicDAO;
import org.xxx.model.entity.Music;

public class MusicService {
	private MusicDAO musicdao=new MusicDAO();
	
	public boolean creat(Music vo) throws Exception{
		return musicdao.creat(vo);
	}
	public List<Music> find() throws Exception {
		return musicdao.find();
	}
		
	public Music findById(Integer id) throws Exception{
		return musicdao.findById(id);
	}
	
	public boolean delete(Integer id)throws Exception{
		return musicdao.delete(id);
	}
	
	public boolean update(Music vo)throws Exception{
		return musicdao.update(vo);
	}
}

