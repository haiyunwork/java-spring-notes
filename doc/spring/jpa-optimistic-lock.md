## JPA Optimistic Lock

### Optmistic Lock

Optimistic locking is a mechanism that prevents an application from being affected by the "lost update" phenomenon in a concurrent environment while allowing some high degree of concurrency at the same time. This is achieved without actually resorting to any locks: Optimistic locking relies on checks that are made against the existing data on the data store by transactions during update time.

| ID |	DESCRIPTION	 | PRICE	| VERSION |
| ---- | ---- | ---- | ---- |
| 1	| Book	| 11.00	| 3 |
| 2	| Television	| 99.00	| 7 |

```sql
UPDATE PRODUCT
SET PRICE = 14.00, VERSION = 4
WHERE ID = 1
AND VERSION = 3;
```

### Optimistic Locking in JPA

Implementing the optimistic locking in JPA is quite simple. You just have to configure your entities with a field annotated with @Version. The JPA provider will take care of issuing update statements in the form we have seen previously (incrementing and checking the version field in each update of a versioned entity) and will also automatically check for the updated row count in order to detect concurrent updates.

If a conflict is detected the JPA provider will throw a javax.persistence.OptimisticLockException.

```java
@Entity
@Table(name = "PRODUCT")
public class Product {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "DESCRIPTION")
  private String description;

  @NotNull
  @Column(name = "PRICE", precision = 9, scale = 2)
  private BigDecimal price;

  @Version
  @Column(name = "VERSION")
  private Integer version;

}
```