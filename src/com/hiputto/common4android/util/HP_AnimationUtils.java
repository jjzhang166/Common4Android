package com.hiputto.common4android.util;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class HP_AnimationUtils {

	// 所有动画结束后，需要在onAnimationEnd中重新设置view的位置、大小。
	// 然后clearAnimation。
	// 执行动画的view最好是RelativeLayout下的子组件，不会影响其他组件。
	//
	// View view = new View();
	// view.startAnimation(new HP_AnimationUtils().animTranslate(0,100,0, 100,
	// 500,new AnimationListener() {
	//
	// @Override
	// public void onAnimationStart(Animation animation) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onAnimationRepeat(Animation animation) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onAnimationEnd(Animation animation) {
	// // TODO Auto-generated method stub
	// LayoutParams params = (LayoutParams) imageView.getLayoutParams();
	// params.height = imageView.getMeasuredHeight();
	// params.width = imageView.getMeasuredWidth();
	// params.setMargins(100, 100, 0, 0);
	// imageView.setLayoutParams(params);
	// imageView.clearAnimation();
	//
	// }
	// }));

	private Animation animationTranslate, animationRotate, animationScale,
			animationAlpha;

	public Animation animScale(float fromX, float toX, float fromY, float toY,
			long duration) {
		animationScale = new ScaleAnimation(1f, toX, 1f, toY,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		animationScale.setDuration(duration);
		animationScale.setFillAfter(true);
		return animationScale;
	}

	public Animation animScale(float fromX, float toX, float fromY, float toY,
			long duration, AnimationListener animationListener) {
		animationScale = new ScaleAnimation(1f, toX, 1f, toY,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		animationScale.setDuration(duration);
		animationScale.setFillAfter(true);
		animationScale.setAnimationListener(animationListener);
		return animationScale;
	}

	public Animation animRotate(float fromDegrees, float toDegrees,
			float pivotXValue, float pivotYValue, long duration) {
		animationRotate = new RotateAnimation(fromDegrees, toDegrees,
				Animation.RELATIVE_TO_SELF, pivotXValue,
				Animation.RELATIVE_TO_SELF, pivotYValue);
		animationRotate.setDuration(duration);
		animationRotate.setFillAfter(true);
		return animationRotate;
	}

	public Animation animRotate(float fromDegrees, float toDegrees,
			float pivotXValue, float pivotYValue, long duration,
			AnimationListener animationListener) {
		animationRotate = new RotateAnimation(fromDegrees, toDegrees,
				Animation.RELATIVE_TO_SELF, pivotXValue,
				Animation.RELATIVE_TO_SELF, pivotYValue);
		animationRotate.setDuration(duration);
		animationRotate.setAnimationListener(animationListener);
		animationRotate.setFillAfter(true);
		return animationRotate;
	}

	public Animation animTranslate(float fromX, float toX, float fromY,
			float toY, long duration) {
		animationTranslate = new TranslateAnimation(fromX, toX, fromY, toY);
		animationTranslate.setDuration(duration);
		animationTranslate.setFillAfter(true);
		return animationTranslate;
	}

	public Animation animTranslate(float fromX, float toX, float fromY,
			float toY, long duration, AnimationListener animationListener) {
		animationTranslate = new TranslateAnimation(fromX, toX, fromY, toY);
		animationTranslate.setDuration(duration);
		animationTranslate.setAnimationListener(animationListener);
		animationTranslate.setFillAfter(true);
		return animationTranslate;
	}

	public Animation animAlpha(float fromAlpha, float toAlpha, long duration) {
		animationAlpha = new AlphaAnimation(fromAlpha, toAlpha);
		animationAlpha.setDuration(duration);
		animationAlpha.setFillAfter(true);
		return animationAlpha;
	}

	public Animation animAlpha(float fromAlpha, float toAlpha, long duration,
			AnimationListener animationListener) {
		animationAlpha = new AlphaAnimation(fromAlpha, toAlpha);
		animationAlpha.setDuration(duration);
		animationAlpha.setFillAfter(true);
		animationAlpha.setAnimationListener(animationListener);
		return animationAlpha;
	}

	/**
	 * start 加速度 center 最大速度 end 减速度
	 * 
	 * @return
	 */
	public static AccelerateDecelerateInterpolator getAccelerateDecelerateInterpolator() {
		return new AccelerateDecelerateInterpolator();
	}

	/**
	 * start 加速度 center 加速度 end 最大速度
	 * 
	 * @return
	 */
	public static AccelerateInterpolator getAccelerateInterpolator() {
		return new AccelerateInterpolator();
	}

	/**
	 * start 加速度 center 加速度 end 最大速度
	 * 
	 * @return
	 */
	public static AccelerateInterpolator getAccelerateInterpolator(float factor) {
		return new AccelerateInterpolator(factor);
	}

	/**
	 * start 反方向减速度 center 速度为零 end 正方向加速度
	 * 
	 * @return
	 */
	public static AnticipateInterpolator getAnticipateInterpolator() {

		return new AnticipateInterpolator();
	}

	/**
	 * start 反方向减速度 center 速度为零 end 正方向加速度
	 * 
	 * @return
	 */
	public static AnticipateInterpolator getAnticipateInterpolator(float tension) {

		return new AnticipateInterpolator(tension);
	}

	/**
	 * start 反方向减速度 center 速度为零 end 正方向加速度到0后反弹到目标位置
	 * 
	 * @return
	 */
	public static AnticipateOvershootInterpolator getAnticipateOvershootInterpolator() {
		return new AnticipateOvershootInterpolator();
	}

	/**
	 * start 反方向减速度 center 速度为零 end 正方向加速度到0后反弹到目标位置
	 * 
	 * @return
	 */
	public static AnticipateOvershootInterpolator getAnticipateOvershootInterpolator(
			float tension) {
		return new AnticipateOvershootInterpolator(tension);
	}

	/**
	 * start 加速度运动 center 速度为零 end 反弹到目标位置
	 * 
	 * @return
	 */
	public static BounceInterpolator getBounceInterpolator() {
		return new BounceInterpolator();
	}

	/**
	 * 运行多少次，多少cycles，多少圈
	 * 
	 * @return
	 */
	public static CycleInterpolator getCycleInterpolator(float cycles) {
		return new CycleInterpolator(cycles);
	}

	/**
	 * start 减速度 center 减速度 end 0
	 * 
	 * @return
	 */
	public static DecelerateInterpolator getDecelerateInterpolator() {
		return new DecelerateInterpolator();
	}

	/**
	 * start 减速度 center 减速度 end 0
	 * 
	 * @return
	 */
	public static DecelerateInterpolator getDecelerateInterpolator(float factor) {
		return new DecelerateInterpolator(factor);
	}

	/**
	 * 匀速运动
	 * 
	 * @return
	 */
	public static LinearInterpolator getLinearInterpolator() {
		return new LinearInterpolator();
	}

	/**
	 * 向前甩一定值后再回到原来位置
	 * 
	 * @return
	 */
	public static OvershootInterpolator getOvershootInterpolator() {
		return new OvershootInterpolator();
	}

	/**
	 * 向前甩一定值后再回到原来位置
	 * 
	 * @return
	 */
	public static OvershootInterpolator getOvershootInterpolator(float tension) {
		return new OvershootInterpolator(tension);
	}

}
