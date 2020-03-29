package com.ys.pattern.factory.abstractfactory.factory;

import com.ys.pattern.factory.abstractfactory.INote;
import com.ys.pattern.factory.abstractfactory.IVideo;
import com.ys.pattern.factory.abstractfactory.PythonNote;
import com.ys.pattern.factory.abstractfactory.PythonVideo;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new PythonNote();
    }


    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
