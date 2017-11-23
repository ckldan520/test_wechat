package org.tiansheng.scs.sdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
//import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

//import com.sina.cloudstorage.SCSClientException;
//import com.sina.cloudstorage.SCSServiceException;
import com.sina.cloudstorage.SDKGlobalConfiguration;
import com.sina.cloudstorage.auth.AWSCredentials;
import com.sina.cloudstorage.auth.BasicAWSCredentials;
import com.sina.cloudstorage.event.ProgressEvent;
import com.sina.cloudstorage.event.ProgressListener;
import com.sina.cloudstorage.services.scs.SCS;
import com.sina.cloudstorage.services.scs.SCSClient;
//import com.sina.cloudstorage.services.scs.model.AccessControlList;
import com.sina.cloudstorage.services.scs.model.Bucket;
//import com.sina.cloudstorage.services.scs.model.CompleteMultipartUploadRequest;
//import com.sina.cloudstorage.services.scs.model.InitiateMultipartUploadResult;
//import com.sina.cloudstorage.services.scs.model.ListPartsRequest;
import com.sina.cloudstorage.services.scs.model.ObjectListing;
import com.sina.cloudstorage.services.scs.model.ObjectMetadata;
//import com.sina.cloudstorage.services.scs.model.PartETag;
//import com.sina.cloudstorage.services.scs.model.PartListing;
//import com.sina.cloudstorage.services.scs.model.Permission;
import com.sina.cloudstorage.services.scs.model.PutObjectRequest;
import com.sina.cloudstorage.services.scs.model.PutObjectResult;
import com.sina.cloudstorage.services.scs.model.S3Object;
//import com.sina.cloudstorage.services.scs.model.UploadPartRequest;
//import com.sina.cloudstorage.services.scs.model.UserIdGrantee;
//import com.sina.cloudstorage.services.scs.transfer.TransferManager;
//import com.sina.cloudstorage.services.scs.transfer.Upload;
//import com.sina.cloudstorage.services.scs.transfer.internal.UploadPartRequestFactory;

public class SampleSDK {
	//accessKey��secretKeyΪ����SCS���˺ź�����
	
	String accessKey = "2xfslemFpGt0Gw5hjCwT";
	String secretKey = "6fdfcbed75998f7476a63f01cb58b1c51ab37ce8";
	
	AWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
	SCS conn = new SCSClient(credentials);
	
/* Service���� */
	/**
	 * ��������getAllBuckets
	 * ���룺��
	 * ���أ���
	 * ���ã���ʾ���е�bucket����
	 */
	public void getAllBuckets(){
		List<Bucket> list = conn.listBuckets();
		System.out.println("====getAllBuckets===="+list);
	}
	
/* Bucket���� */
	
	/**
	 * ��������createBucket
	 * ���룺bucket������
	 * ���أ���
	 * ���ã�����һ��Bucket
	 */
	public void createBucket(String bucket_name){
		conn.createBucket(bucket_name);
	}
	/**
	 * ��������listObjects
	 * ���룺bucket������
	 * ���أ���
	 * ���ã���ʾbucket�е������ļ�
	 */
	public void listObjects(String bucket_name){
		ObjectListing objectListing = conn.listObjects(bucket_name);
		System.out.println(objectListing);
	}
	
/* Object���� */
	/**
	 * ��������getObject
	 * ���룺bucket������,�ļ���,���ش洢��ַ��
	 * ���أ���
	 * ���ã�����bucket��ĳһ�ļ�
	 */
	public void getObject(String bucket_name, String object_name, String local_name){
		SDKGlobalConfiguration.setGlobalTimeOffset(-60*5);//��ʱʱ��5�����Ժ�
		S3Object s3Obj = conn.getObject(bucket_name, object_name);
		InputStream in = s3Obj.getObjectContent();
		byte[] buf = new byte[1024];
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(local_name));
			int count;
			while( (count = in.read(buf)) != -1)
			{
			   if( Thread.interrupted() )
			   {
			       throw new InterruptedException();
			   }
			   out.write(buf, 0, count);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			SDKGlobalConfiguration.setGlobalTimeOffset(0);
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��������putObject
	 * ���룺bucket������,�ļ���,���ش洢��ַ��
	 * ���أ���
	 * ���ã��ϴ������ļ���Bucket��
	 */
	public void putObject(String bucket_name, String object_name, String local_name){
		PutObjectRequest por = new PutObjectRequest(bucket_name, object_name, 
				new File(local_name)).withMetadata(new ObjectMetadata());
		por.setGeneralProgressListener(new ProgressListener() {
			@Override
			public void progressChanged(ProgressEvent progressEvent) {
				System.out.println(progressEvent);
			}
		});
		
		PutObjectResult putObjectResult = conn.putObject(por);
		System.out.println(putObjectResult);
		
	}
	/**
	 * ��������deleteObject
	 * ���룺bucket������,�ļ���
	 * ���أ���
	 * ���ã�ɾ��bucket�е�ĳһ�ļ�
	 */
	public void deleteObject(String bucket_name, String object_name){
		conn.deleteObject(bucket_name, object_name);
	}
	
	/**
	 * ��������generateUrl
	 * ���룺bucket������,�ļ���
	 * ���أ�URL
	 * ���ã��鿴bucket��ĳ�ļ���Url
	 */
	public URL generateUrl(String bucket_name, String object_name){
		Date expiration = new Date();
        long epochMillis = expiration.getTime();
        epochMillis += 60*5*1000;
        expiration = new Date(epochMillis);   
        
		URL presignedUrl = conn.generatePresignedUrl(bucket_name, object_name, expiration, false);
		//System.out.println(presignedUrl);
		return presignedUrl;
	}
	
	/**
	 * ��������getDocumentAt
	 * ���룺�ļ���url
	 * ���أ�string
	 * ���ã�����url��ȡ�ļ�����
	 */
	public  String getDocumentAt(String urlString) {
	    //�˷�������HTTP��FTPЭ��
	    StringBuffer document = new StringBuffer();

	    try {

	         URL url = new URL(urlString);

	         URLConnection conn = url.openConnection();

	         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	         String line = null;

	         while ( (line = reader.readLine()) != null) {
	             document.append(line + " ");
	         }

	         reader.close();

	    } catch (MalformedURLException e) {
	        System.out.println("Unable to connect to URL: " + urlString);
	    } catch (IOException e) {
	        System.out.println("IOException when connecting to URL: " + urlString);
	    }
	     return document.toString();
	 }
	
//�������õ�������//////////////////	
	public static void main(String[] args) throws InterruptedException, DocumentException{		
//		SampleSDK sample = new SampleSDK();
//		sample.getAllBuckets();
		
//		SampleSDK sample = new SampleSDK();
//		URL urlString=sample.generateUrl("wechat-package1-image","zmyqj_status.xml");
////		String temp=urlString.toString();
////		Thread.sleep(1000);
////		String str_xml=sample.getDocumentAt(temp);
//		
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(urlString);
////		Document document = reader.read(new File("E:\\zmyqj_status.xml"));
//		
//		Element root = document.getRootElement();
//		   
//		Element ec = (Element)root.selectSingleNode("//STATUS/DeviceTemperature"); 
//		System.out.println(ec.attributeValue("value")); 
		Show_data test=new Show_data();
		test.read_data(" ");
		
	}
}
