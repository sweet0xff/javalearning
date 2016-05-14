package org.xxx.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class LoadAction {
	//服务器文件名集合
		private List<String> filenamelist = new ArrayList<String>();

		public List<String> getFilenamelist() {
			return filenamelist;
		}

		public void setFilenamelist(List<String> filenamelist) {
			this.filenamelist = filenamelist;
		}
		
	//上传的文件
	private File upload;
	//上传的文件名
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	//文件上传
	public String upload() throws Exception{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(upload));

		String path = ServletActionContext.getServletContext().getRealPath("upload");
		System.out.print(path);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + "/" + uploadFileName));
		byte [] data= new byte[100];
		int temp=-1;
		while((temp=in.read(data)) !=-1){
			System.out.println(temp);
			out.write(temp);
		}

		out.close();
		in.close();
		return "success";
	}
	

	//获取文件列表
	public String filelist(){
		//从upload文件夹下载文件
		String downpath=ServletActionContext.getServletContext().getRealPath("upload");
		File file = new File(downpath);
		File[] files= file.listFiles();
		for(int i = 0;i<files.length;i++){
			String singleFilename= files[i].getName();
			if(singleFilename !=null){
				filenamelist.add(singleFilename);
			}
		}
		return "filelist";
	}
	
	//文件下载
	public String down(){
		return "down";
	}
	
	public InputStream getInputStream() throws FileNotFoundException{
		if(uploadFileName != null){
			String path = ServletActionContext.getServletContext().getRealPath("upload");
			String downpath = path + "/" + uploadFileName;
			
			FileInputStream in = new FileInputStream(downpath);
			return in;
		}else {
			return null;
		}
		
	}
	
}
