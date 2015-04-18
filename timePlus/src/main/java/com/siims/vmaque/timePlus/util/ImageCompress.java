package com.siims.vmaque.timePlus.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class ImageCompress {
	
	/**
	 * 描述：
	 * 
	 * @param path
	 *            需要压缩的图片路径
	 * @param fileName
	 *            要压缩的图片名称
	 * @param toFileName
	 *            压缩后的图片名称
	 * @param scale
	 *            压缩比例 不能大于1,默认0.5
	 * @param quality
	 *            压缩品质介于0.1~1.0之间
	 * @param width
	 *            压缩后的图片的宽度
	 * @param height
	 *            压缩后的图片的高度 返回值：void
	 */
	static void imageCompress(String path, String fileName, String toFileName,
			float scale, float quality, int width, int height) {
		try { // 原图路径 原图名称 目标路径 压缩比率0.5 0.75 原图宽度 原图高度
			Image image = ImageIO.read(new File(path + fileName));
			int imageWidth = image.getWidth(null);
			int imageHeight = image.getHeight(null);
			if (scale > 0.5)
				scale = 0.5f;// 默认压缩比为0.5，压缩比越大，对内存要去越高，可能导致内存溢出
			// 按比例计算出来的压缩比
			float realscale = getRatio(imageWidth, imageHeight, width, height);
			float finalScale = Math.min(scale, realscale);// 取压缩比最小的进行压缩
			imageWidth = (int) (finalScale * imageWidth);
			imageHeight = (int) (finalScale * imageHeight);

			image = image.getScaledInstance(imageWidth, imageHeight,
					Image.SCALE_AREA_AVERAGING);
			// Make a BufferedImage from the Image.
			BufferedImage mBufferedImage = new BufferedImage(imageWidth,
					imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = mBufferedImage.createGraphics();

			g2.drawImage(image, 0, 0, imageWidth, imageHeight, Color.white,
					null);
			g2.dispose();

			float[] kernelData2 = { -0.125f, -0.125f, -0.125f, -0.125f, 2,
					-0.125f, -0.125f, -0.125f, -0.125f };
			Kernel kernel = new Kernel(3, 3, kernelData2);
			ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
			mBufferedImage = cOp.filter(mBufferedImage, null);

			FileOutputStream out = new FileOutputStream(path + toFileName);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(mBufferedImage);
			param.setQuality(quality, true);// 默认0.75
			encoder.setJPEGEncodeParam(param);
			encoder.encode(mBufferedImage);
			out.close();
			
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			 ioe.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}

	public static void imageCompress(String path, String fileName,
			String toFileName, float scale) {
		File file = new File(path+fileName);
		
		int width = getImgWidth(file);
		int height = getImgHeight(file);
		
		imageCompress(path, fileName, toFileName, scale, 0.75f, width, height);
	}

	/**
     * 获取图片宽度
     * 
     * @param file 图片文件
     * @return 宽度
     */
    public static int getImgWidth(File file) {
        ImageInputStream iis = null;
        int width = 0;
		try {
	    	Iterator<ImageReader> it = CutImgUtil.getImageReadersByFormatName(CutImgUtil.getPostfix(file.getName()).equals("jpg") ? 0 : 1);
	        ImageReader reader = (ImageReader)it.next();
			iis = ImageIO.createImageInputStream(file);
	        reader.setInput(iis, true);
	        width = reader.getWidth(0);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            if (iis != null) {
				try {
					iis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
		}
        
        return width;
    }

    /**
     * 获取图片高度
     * 
     * @param file 图片文件
     * @return 高度
     */
    public static int getImgHeight(File file) {
    	ImageInputStream iis = null;
        int height = 0;
		try {
	    	Iterator<ImageReader> it = CutImgUtil.getImageReadersByFormatName(CutImgUtil.getPostfix(file.getName()).equals("jpg") ? 0 : 1);
	        ImageReader reader = (ImageReader)it.next();
			iis = ImageIO.createImageInputStream(file);
	        reader.setInput(iis, true);
	        height = reader.getHeight(0);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            if (iis != null) {
				try {
					iis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
		}
        
        return height;
    }
	
	/**
	 * 获得压缩比率的方法
	 * @param width
	 * @param height
	 * @param maxWidth
	 * @param maxHeight
	 * @return
	 */
	private static float getRatio(int width, int height, int maxWidth,
			int maxHeight) {
		float Ratio = 1.0f;
		float widthRatio;
		float heightRatio;
		widthRatio = (float) maxWidth / width;
		heightRatio = (float) maxHeight / height;
		if (widthRatio < 1.0 || heightRatio < 1.0) {
			Ratio = widthRatio <= heightRatio ? widthRatio : heightRatio;
		}
		return Ratio;
	}

	/**
	 * 图片格式转换
	 * @param imageFile
	 * @param imageType
	 * @return
	 * @throws Exception
	 */
	public static byte[] convertImage2Type(String imageFile, String imageType)
			throws Exception {
		File inputFile = new File(imageFile);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		BufferedImage input = ImageIO.read(inputFile);
		ImageIO.write(input, imageType, output);
		return output.toByteArray();
	}

	/**
	 * 图片格式转换
	 * @param imageFile
	 * @param imageType
	 * @throws Exception
	 */
	public static void convertImage2TypePng(String imageFile, String imageType)
			throws Exception {
		File inputFile = new File(imageFile);
		int suffixIndex = imageFile.lastIndexOf(".");
		String suffix = imageFile.substring(suffixIndex + 1);
		if (!"png".equals(suffix)) {// 如果原图片的不是PNG格式的图片
			String fileName = imageFile.substring(0, suffixIndex + 1) + "png";
			File output = new File(fileName);
			BufferedImage input = ImageIO.read(inputFile);
			ImageIO.write(input, imageType, output);
			// 转换后删除原文件
			if (inputFile.exists())
				inputFile.delete();
		}
	}

}