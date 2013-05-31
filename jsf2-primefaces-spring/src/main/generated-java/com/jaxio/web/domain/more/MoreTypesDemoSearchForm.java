/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 */
package com.jaxio.web.domain.more;

import static com.jaxio.dao.support.PropertySelector.newPropertySelector;
import static com.jaxio.dao.support.Ranges.RangeBigDecimal.newRangeBigDecimal;
import static com.jaxio.dao.support.Ranges.RangeBigInteger.newRangeBigInteger;
import static com.jaxio.dao.support.Ranges.RangeDate.newRangeDate;
import static com.jaxio.dao.support.Ranges.RangeDouble.newRangeDouble;
import static com.jaxio.dao.support.Ranges.RangeFloat.newRangeFloat;
import static com.jaxio.dao.support.Ranges.RangeInteger.newRangeInteger;
import static com.jaxio.dao.support.Ranges.RangeLocalDate.newRangeLocalDate;
import static com.jaxio.dao.support.Ranges.RangeLocalDateTime.newRangeLocalDateTime;
import static com.jaxio.dao.support.Ranges.RangeLong.newRangeLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Named;
import com.jaxio.dao.support.PropertySelector;
import com.jaxio.dao.support.Ranges.RangeBigDecimal;
import com.jaxio.dao.support.Ranges.RangeBigInteger;
import com.jaxio.dao.support.Ranges.RangeDate;
import com.jaxio.dao.support.Ranges.RangeDouble;
import com.jaxio.dao.support.Ranges.RangeFloat;
import com.jaxio.dao.support.Ranges.RangeInteger;
import com.jaxio.dao.support.Ranges.RangeLocalDate;
import com.jaxio.dao.support.Ranges.RangeLocalDateTime;
import com.jaxio.dao.support.Ranges.RangeLong;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.more.MoreTypesDemo;
import com.jaxio.domain.more.MoreTypesDemo_;
import com.jaxio.web.domain.support.GenericSearchForm;
import com.jaxio.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link MoreTypesDemo}.
 * It exposes a {@link MoreTypesDemo} instance so it can be used in search by Example query.
 */
@Named
@ConversationContextScoped
public class MoreTypesDemoSearchForm extends GenericSearchForm<MoreTypesDemo, Integer, MoreTypesDemoSearchForm> {
    private static final long serialVersionUID = 1L;

    protected MoreTypesDemo moreTypesDemo = new MoreTypesDemo();
    protected RangeInteger<MoreTypesDemo> numberIntRange = newRangeInteger(MoreTypesDemo_.numberInt);
    protected RangeLong<MoreTypesDemo> numberLongRange = newRangeLong(MoreTypesDemo_.numberLong);
    protected RangeDouble<MoreTypesDemo> numberDoubleRange = newRangeDouble(MoreTypesDemo_.numberDouble);
    protected RangeFloat<MoreTypesDemo> numberFloatRange = newRangeFloat(MoreTypesDemo_.numberFloat);
    protected RangeBigInteger<MoreTypesDemo> numberBigIntegerRange = newRangeBigInteger(MoreTypesDemo_.numberBigInteger);
    protected RangeBigDecimal<MoreTypesDemo> numberBigDecimalRange = newRangeBigDecimal(MoreTypesDemo_.numberBigDecimal);
    protected RangeDate<MoreTypesDemo> dateJavaTemporalDateRange = newRangeDate(MoreTypesDemo_.dateJavaTemporalDate);
    protected RangeDate<MoreTypesDemo> dateJavaTemporalTimestampRange = newRangeDate(MoreTypesDemo_.dateJavaTemporalTimestamp);
    protected RangeLocalDate<MoreTypesDemo> dateJodaRange = newRangeLocalDate(MoreTypesDemo_.dateJoda);
    protected RangeLocalDateTime<MoreTypesDemo> dateTimeJodaRange = newRangeLocalDateTime(MoreTypesDemo_.dateTimeJoda);
    protected PropertySelector<MoreTypesDemo, Integer> numberIntSelector = newPropertySelector(MoreTypesDemo_.numberInt);
    protected PropertySelector<MoreTypesDemo, Long> numberLongSelector = newPropertySelector(MoreTypesDemo_.numberLong);
    protected PropertySelector<MoreTypesDemo, Double> numberDoubleSelector = newPropertySelector(MoreTypesDemo_.numberDouble);
    protected PropertySelector<MoreTypesDemo, Float> numberFloatSelector = newPropertySelector(MoreTypesDemo_.numberFloat);
    protected PropertySelector<MoreTypesDemo, BigInteger> numberBigIntegerSelector = newPropertySelector(MoreTypesDemo_.numberBigInteger);
    protected PropertySelector<MoreTypesDemo, BigDecimal> numberBigDecimalSelector = newPropertySelector(MoreTypesDemo_.numberBigDecimal);

    public MoreTypesDemo getMoreTypesDemo() {
        return moreTypesDemo;
    }

    @Override
    protected MoreTypesDemo getEntity() {
        return getMoreTypesDemo();
    }

    @Override
    public MoreTypesDemoSearchForm newInstance() {
        return new MoreTypesDemoSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        return new SearchParameters() //
                .anywhere() //
                .range(numberIntRange) //
                .range(numberLongRange) //
                .range(numberDoubleRange) //
                .range(numberFloatRange) //
                .range(numberBigIntegerRange) //
                .range(numberBigDecimalRange) //
                .range(dateJavaTemporalDateRange) //
                .range(dateJavaTemporalTimestampRange) //
                .range(dateJodaRange) //
                .range(dateTimeJodaRange) //
                .property(numberIntSelector) //
                .property(numberLongSelector) //
                .property(numberDoubleSelector) //
                .property(numberFloatSelector) //
                .property(numberBigIntegerSelector) //
                .property(numberBigDecimalSelector) //
        ;
    }

    @Override
    public void resetWithOther(MoreTypesDemoSearchForm other) {
        this.moreTypesDemo = other.getMoreTypesDemo();
        this.numberIntRange = other.getNumberIntRange();
        this.numberLongRange = other.getNumberLongRange();
        this.numberDoubleRange = other.getNumberDoubleRange();
        this.numberFloatRange = other.getNumberFloatRange();
        this.numberBigIntegerRange = other.getNumberBigIntegerRange();
        this.numberBigDecimalRange = other.getNumberBigDecimalRange();
        this.dateJavaTemporalDateRange = other.getDateJavaTemporalDateRange();
        this.dateJavaTemporalTimestampRange = other.getDateJavaTemporalTimestampRange();
        this.dateJodaRange = other.getDateJodaRange();
        this.dateTimeJodaRange = other.getDateTimeJodaRange();
        this.numberIntSelector = other.getNumberIntSelector();
        this.numberLongSelector = other.getNumberLongSelector();
        this.numberDoubleSelector = other.getNumberDoubleSelector();
        this.numberFloatSelector = other.getNumberFloatSelector();
        this.numberBigIntegerSelector = other.getNumberBigIntegerSelector();
        this.numberBigDecimalSelector = other.getNumberBigDecimalSelector();
    }

    // Ranges
    public RangeInteger<MoreTypesDemo> getNumberIntRange() {
        return numberIntRange;
    }

    public RangeLong<MoreTypesDemo> getNumberLongRange() {
        return numberLongRange;
    }

    public RangeDouble<MoreTypesDemo> getNumberDoubleRange() {
        return numberDoubleRange;
    }

    public RangeFloat<MoreTypesDemo> getNumberFloatRange() {
        return numberFloatRange;
    }

    public RangeBigInteger<MoreTypesDemo> getNumberBigIntegerRange() {
        return numberBigIntegerRange;
    }

    public RangeBigDecimal<MoreTypesDemo> getNumberBigDecimalRange() {
        return numberBigDecimalRange;
    }

    public RangeDate<MoreTypesDemo> getDateJavaTemporalDateRange() {
        return dateJavaTemporalDateRange;
    }

    public RangeDate<MoreTypesDemo> getDateJavaTemporalTimestampRange() {
        return dateJavaTemporalTimestampRange;
    }

    public RangeLocalDate<MoreTypesDemo> getDateJodaRange() {
        return dateJodaRange;
    }

    public RangeLocalDateTime<MoreTypesDemo> getDateTimeJodaRange() {
        return dateTimeJodaRange;
    }

    // Property selectors
    public PropertySelector<MoreTypesDemo, Integer> getNumberIntSelector() {
        return numberIntSelector;
    }

    public PropertySelector<MoreTypesDemo, Long> getNumberLongSelector() {
        return numberLongSelector;
    }

    public PropertySelector<MoreTypesDemo, Double> getNumberDoubleSelector() {
        return numberDoubleSelector;
    }

    public PropertySelector<MoreTypesDemo, Float> getNumberFloatSelector() {
        return numberFloatSelector;
    }

    public PropertySelector<MoreTypesDemo, BigInteger> getNumberBigIntegerSelector() {
        return numberBigIntegerSelector;
    }

    public PropertySelector<MoreTypesDemo, BigDecimal> getNumberBigDecimalSelector() {
        return numberBigDecimalSelector;
    }
}
