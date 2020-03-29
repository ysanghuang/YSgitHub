package com.ys.pattern.factory.abstractfactory.factory;

import com.ys.pattern.factory.abstractfactory.INote;
import com.ys.pattern.factory.abstractfactory.IVideo;
import com.ys.pattern.factory.abstractfactory.JavaNote;
import com.ys.pattern.factory.abstractfactory.JavaVideo;

/**
 * Created by Tom.
 */
public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
