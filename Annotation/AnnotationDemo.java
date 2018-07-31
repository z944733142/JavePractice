
package app.xupt.Annotation;


@a2Annotation(Id = 16)
//@aAnnotation 错误
public class AnnotationDemo {
    @a2Annotation(Id = 15, value = "aaaa")
    @aAnnotation
    public void test ()
    {

    }
}


