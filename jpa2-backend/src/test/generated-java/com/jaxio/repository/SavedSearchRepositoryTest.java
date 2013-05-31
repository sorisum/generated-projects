/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/RepositoryTest.e.vm.java
 */
package com.jaxio.repository;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jaxio.domain.SavedSearch;
import com.jaxio.repository.SavedSearchRepository;
import com.jaxio.dao.SavedSearchDao;
import com.jaxio.dao.support.SearchParameters;

/**
 * Unit test on SavedSearchRepository
 */
@RunWith(MockitoJUnitRunner.class)
public class SavedSearchRepositoryTest {

    @Mock
    private SavedSearchDao savedSearchDao;

    @InjectMocks
    private SavedSearchRepository savedSearchRepository;

    @Test
    public void findUniqueOrNoneReturnsNull() {
        when(savedSearchDao.findUniqueOrNone(any(SavedSearch.class), any(SearchParameters.class))).thenReturn(null);

        SavedSearch result = savedSearchRepository.findUniqueOrNone(new SavedSearch());

        assertThat(result).isNull();
        verify(savedSearchDao, times(1)).findUniqueOrNone(any(SavedSearch.class), any(SearchParameters.class));
    }

    @Test
    public void findUniqueOrNoneReturnsSingleValue() {
        SavedSearch unique = new SavedSearch();

        when(savedSearchDao.findUniqueOrNone(any(SavedSearch.class), any(SearchParameters.class))).thenReturn(unique);

        SavedSearch result = savedSearchRepository.findUniqueOrNone(new SavedSearch());

        assertThat(result).isNotNull().isSameAs(unique);
        verify(savedSearchDao, times(1)).findUniqueOrNone(any(SavedSearch.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void findUniqueOrNoneThrowsExceptionWhenNonUniqueResults() {
        when(savedSearchDao.findUniqueOrNone(any(SavedSearch.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        savedSearchRepository.findUniqueOrNone(new SavedSearch());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void findUniqueThrowsExceptionWhenNoResult() {
        when(savedSearchDao.findUnique(any(SavedSearch.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        savedSearchRepository.findUnique(new SavedSearch());
    }

    @Test
    public void findUnique() {
        SavedSearch unique = new SavedSearch();

        when(savedSearchDao.findUnique(any(SavedSearch.class), any(SearchParameters.class))).thenReturn(unique);

        SavedSearch result = savedSearchRepository.findUnique(new SavedSearch());

        assertThat(result).isNotNull();
        verify(savedSearchDao, times(1)).findUnique(any(SavedSearch.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void findUniqueThrowsExeptionWhenNonUniqueResult() {
        when(savedSearchDao.findUnique(any(SavedSearch.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        savedSearchRepository.findUnique(new SavedSearch());
    }
}