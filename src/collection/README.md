
### 集合框架``


#### HashSet 

###### 在Set中对象怎么才算相等？

    1. 引用相等性：堆上同一对象的两个引用。
    2. 对象相等：堆上两个不同的对象在意义上相等。



###### HashSet 如何检查重复 hashCode和equals ？

    hashCode判断对象加入set中的位置，如果存在相同的hashCode，那么会调用其中一个的
    equals方法，判断它们的值是否一样。如果两者一样，那么就认为这两对象是相等的，set中存在相同的
    元素了。
    
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Song song = (Song) o;
            return Objects.equals(id, song.id) &&
                    Objects.equals(title, song.title) &&
                    Objects.equals(author, song.author);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(id, title, author);
        }



###### 为什么String类型的对象在内存中不同，值相同了，在Set，HashMap的key认为是相同的？
    
    1. String类改写了HashCode、equals方法。 
    2. hashCode是某个hash算法算出，如果两个String的内容是相等的，那么hashCode是相等的。
    3. equals: 
        1）判断两者是否指向同一对象，
        2）判断是否String类型
        3）判断两种的字符数组是否相等
        4) 循环判断字符数组的每个字符是否一样。

#### TreeSet

###### TreeSet 是怎样去重和确定排序的呢？ 【CompareTo()】    

       要使用treeSet; 必须满足以下两种条件之一；
       1） 集合中的元素必须是有实现Comparable的类型
       
            @Override
            public int compareTo(Object o) {
                Book book = (Book) o;
                return name.compareTo(book.name);
            }
            
            并且会根据name判断有木有重复元素。
                
       2） 使用重载、取用Comparator参数的构造函数来创建TreeSet
       
       之定义排序的集合；
       
       class BookCompare implements Comparator<Book> {
       
           @Override
           public int compare(Book o1, Book o2) {
               return o1.getId().compareTo(o2.getId());
           }
       }
            
           根据id，去重并且按照id升序排序。
           
           

       
       