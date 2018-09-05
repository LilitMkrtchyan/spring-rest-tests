package com.test.recruitment.json;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Transaction json representation
 *
 * @author lilitmk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CreateTransactionRequest extends AbstractTransaction implements Serializable {
}