package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.webjars.WebJarAssetLocator;

/**
 * 处理WebJars，自动读取版本号
 *
 */
@Controller
public class WebJarsController {

	private final WebJarAssetLocator assetLocator = new WebJarAssetLocator();

	@ResponseBody
	@RequestMapping("/webjarslocator/{webjar}/**")
	public ResponseEntity<Object> locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
		try {
			// This prefix must match the mapping path!
			String mvcPrefix = "/webjarslocator/" + webjar + "/"; 
			String mvcPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			String fullPath = assetLocator.getFullPath(webjar, mvcPath.substring(mvcPrefix.length()));
//			System.out.println(mvcPrefix);
//			System.out.println(mvcPath);
//			System.out.println(fullPath);
			return new ResponseEntity<>(new ClassPathResource(fullPath), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
