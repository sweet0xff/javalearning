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
	//�������ļ�������
		private List<String> filenamelist = new ArrayList<String>();

		public List<String> getFilenamelist() {
			return filenamelist;
		}

		public void setFilenamelist(List<String> filenamelist) {
			this.filenamelist = filenamelist;
		}
		
	//�ϴ����ļ�
	private File upload;
	//�ϴ����ļ���
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
	
	
	//�ļ��ϴ�
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
	

	//��ȡ�ļ��б�
	public String filelist(){
		//��upload�ļ��������ļ�
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
	
	//�ļ�����
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
