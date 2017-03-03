# AnyShapeImageView
android ImageView for any shape
# Android ImageView For Any Shape
![image](http://upload-images.jianshu.io/upload_images/1648595-42e428949f5203ef.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image](http://upload-images.jianshu.io/upload_images/1648595-3a1462fe0f09d7f7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image](http://upload-images.jianshu.io/upload_images/1648595-25ac74abe29f84eb.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image](http://upload-images.jianshu.io/upload_images/1648595-49b4d884beb4158e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### use shapePic to set the shape you want to get，use backgroundPic to set the background,that's ok. 
p.s. both parameters are for image resource,the background color in the shape picture is transparent，not white
### shapePic来设置形状，backgroundPic 设置背景，然后就可以把背景图设置成任意形状。
注：这两个属性都是图片，设置形状的图片的背景色是透明，不是白色

Download
Gradle
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.lipeiyan:AnyShapeImageView:0.0.1'
	}
```
Maven
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Step 2. Add the dependency
```
	<dependency>
	    <groupId>com.github.lipeiyan</groupId>
	    <artifactId>AnyShapeImageView</artifactId>
	    <version>0.0.1</version>
	</dependency>
```
