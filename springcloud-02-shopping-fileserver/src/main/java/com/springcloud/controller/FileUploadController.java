package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {

	// 浠巃pplication.properties鏂囦欢涓幏寰楁寚瀹氶敭鐨勫�硷紝骞惰祴缁欑浉搴旂殑鎴愬憳鍙橀噺
	@Value("${web.user-path}")
	private String userPath;

	@Value("${web.goods-path}")
	private String goodsPath;

	/**
	 * 涓婁紶鐢ㄦ埛澶村儚
	 * 
	 * @param file 涓婁紶鐢ㄦ埛澶村儚鏂囦欢
	 * @return
	 */
	@RequestMapping(value = "/userUpload")
	public ResultValue userUpload(@RequestParam("userImage") MultipartFile file) {

		ResultValue rv = new ResultValue();

		// 涓婁紶鏂囦欢
		try {
			Map<String, Object> map = this.fileUpload(file, userPath);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("鐢ㄦ埛澶村儚涓婁紶澶辫触锛侊紒锛�");
		return rv;
	}

	/**
	 * 涓婁紶鍟嗗搧鍥剧墖
	 * 
	 * @param file 涓婁紶鍟嗗搧鍥剧墖鏂囦欢
	 * @return
	 */
	@RequestMapping(value = "/goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {

		ResultValue rv = new ResultValue();

		// 涓婁紶鏂囦欢
		try {
			Map<String, Object> map = this.fileUpload(file, goodsPath);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("鍟嗗搧鍥剧墖涓婁紶澶辫触锛侊紒锛�");
		return rv;
	}
	@RequestMapping(value ="/deleteGoodsImg")
	public 	ResultValue deleteGoodsImg(@RequestParam("goodsImg") String goodsImg) {
		ResultValue rv = new ResultValue();
		
		try {
			//浠嶶RL涓幏寰楀晢鍝佸浘鐗囩殑鍚嶅瓧
			int indexOf = goodsImg.lastIndexOf("/");
			if(indexOf != -1)
			{
				String fileName = goodsImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//鍒ゆ柇鏂囦欢鎴栫洰褰曟槸鍚﹀瓨鍦�
				if(file.exists())
				{
					if(file.isFile())
					{
						file.delete();
						rv.setCode(0);
						return rv;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	@RequestMapping(value ="/deleteUserImg")
	public 	ResultValue deleteUserImg(@RequestParam("userImg") String userImg) {
		ResultValue rv = new ResultValue();
		
		try {
			//浠嶶RL涓幏寰楀晢鍝佸浘鐗囩殑鍚嶅瓧
			int indexOf = userImg.lastIndexOf("/");
			if(indexOf != -1)
			{
				String fileName = userImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//鍒ゆ柇鏂囦欢鎴栫洰褰曟槸鍚﹀瓨鍦�
				if(file.exists())
				{
					if(file.isFile())
					{
						file.delete();
						rv.setCode(0);
						return rv;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}


	/**
	 * 涓婁紶鏂囦欢
	 * 
	 * @param file 闇�瑕佷笂浼犵殑鏂囦欢
	 * @param path 涓婁紶鏂囦欢鐨勮矾寰�
	 * @return 鎴愬姛杩斿洖java.util.Map绫诲瀷鐨勫疄渚嬶紝鍚﹀垯杩斿洖null
	 * @throws IOException
	 */
	private Map<String, Object> fileUpload(MultipartFile file, String path) throws IOException {
		Map<String, Object> map = null;

		// 鑾峰緱鏂扮殑鏂囦欢鍚�
		String fileName = UploadUtils.getFileName();

		// 鏍规嵁涓婁紶鏂囦欢鐨勬枃浠跺悕鑾峰緱鏂囦欢鐨勬墿灞曞悕
		String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());

		// 涓婁紶鏂囦欢
		// 1.灏嗘枃浠惰浆鎹负瀛楄妭绫诲瀷鐨勬暟缁�
		byte[] bytes = file.getBytes();
		// 2.鍒涘缓File绫荤殑瀵硅薄锛屽苟璁剧疆鏂囦欢鐨勪笂浼犺矾寰勫拰鏂囦欢鍚嶃�侳ile鍦↗ava涓〃绀烘枃浠舵垨鑰呯洰褰�
		File saveFile = new File(path + fileName + extendedName);
		// 3.涓婁紶鏂囦欢
		FileCopyUtils.copy(bytes, saveFile);

		map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName", extendedName);

		return map;
	}

}
