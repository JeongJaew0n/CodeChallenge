package study.efectivejava.item39;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}

// 추가로 사용할 수 있는 것들
//@Retention(RetentionPolicy.SOURCE) // 컴파일 되어 class 파일이 되면 사라진다.
//@Retention(RetentionPolicy.CLASS) // 런타임 시에 사라진다.
//
//@Target(ElementType.ANNOTATION_TYPE)
//@Target(ElementType.CONSTRUCTOR)
//@Target(ElementType.FIELD) // 멤버 변수, Enum 상수
//@Target(ElementType.LOCALVARIABLE) // 지역 변수
//@Target(ElementType.PACKAGE)
//@Target(ElementType.PARAMETER) // 매개변수
//@Target(ElementType.TYPE) // 클래스, 인터페이스
//@Target(ElementType.TYPE_PARAMETER) // 매개변수화 타입(제네릭)
//@Target(ElementType.TYPE_USE) // 모든 타입