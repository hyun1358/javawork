package week11.day6;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Table {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

@Table(name = "member_info")
class UserEntity {
    @Column(name = "mem_id")
    private int id;

    @Column(name = "mem_name")
    private String name;

    public UserEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class MiniProjectAnswer {
    public static void main(String[] args) throws Exception {
        UserEntity user = new UserEntity(101, "홍길동");
        String sql = generateInsert(user);
        System.out.println("자동 생성된 쿼리: ");
        System.out.println(sql);
    }

    public static String generateInsert(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(Table.class)) return null;

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();

        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Column.class)) {
                Column col = f.getAnnotation(Column.class);
                cols.append(col.name()).append(", ");

                f.setAccessible(true);
                Object value = f.get(obj);

                if (value instanceof String) vals.append("'").append(value).append("', ");
                else vals.append(value).append(", ");
            }
        }

        // 마지막 쉼표 제거
        if (cols.length() > 0) {
            cols.setLength(cols.length() - 2);
            vals.setLength(vals.length() - 2);
        }

        return String.format("INSERT INTO %s (%s) VALUES (%s);", tableName, cols, vals);
    }
}
