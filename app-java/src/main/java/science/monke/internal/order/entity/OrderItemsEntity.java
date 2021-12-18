package science.monke.internal.order.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items", schema = "quarkus_reference_project")
public class OrderItemsEntity extends PanacheEntityBase {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private int id;
  @Basic
  @Column(name = "creation_date")
  private OffsetDateTime creationDate;
  @Basic
  @Column(name = "order_id")
  private UUID orderId;

}
