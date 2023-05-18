package com.banking;

import com.banking.models.notifications;
import com.banking.models.savingsAccountInfo;
import com.banking.repositories.notificationsRepo;
import com.banking.services.notificationsServiceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

//@WebMvcTest
public class notificationServiceTest<NotificationsServiceimpl, NotificationsRepo> {

    @InjectMocks
    notificationsServiceimpl testUser;

    @Mock
    notificationsRepo mockitoDao;


    private final notifications MOCK_NOTIFICATIONS_1 = new notifications(11, "John Doe", "jdoe@gmail.com", "Description1", 123456789, 3, 1001);
    private final notifications MOCK_NOTIFICATIONS_2 = new notifications(12, "Patrick Junior", "pjunior@gmail.com", "Description2", 987654321, 30, 1002);
    private final notifications MOCK_NOTIFICATIONS_3 = new notifications(14, "Steve Nash", "snash@gmail.com", "Description3", 113355779, 300, 1003);
    private final notifications MOCK_NOTIFICATIONS_4 = new notifications(10, "Michael Jordan", "mj@gmail.com", "Description4", 224466880, 3000, 1004);
    private final notifications MOCK_NOTIFICATIONS_5 = new notifications(13, "Paco Colo", "pcolo@gmail.com", "Description5", 224466881, 3003, 1005);


    private List<notifications> MOCK_ALL_NOTIFICATIONS;
    private List<notifications> MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1;
    private List<notifications> MOCK_ALL_NOTIFICATIONS_FOR_CREATE;

    @BeforeEach
    public void init() {
        openMocks(this);

        MOCK_ALL_NOTIFICATIONS = new ArrayList<>();
        MOCK_ALL_NOTIFICATIONS.add(MOCK_NOTIFICATIONS_1);
        MOCK_ALL_NOTIFICATIONS.add(MOCK_NOTIFICATIONS_2);
        MOCK_ALL_NOTIFICATIONS.add(MOCK_NOTIFICATIONS_3);
        MOCK_ALL_NOTIFICATIONS.add(MOCK_NOTIFICATIONS_4);

        System.out.println(MOCK_ALL_NOTIFICATIONS.toString());

        MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1 = new ArrayList<>();
        MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1.add(MOCK_NOTIFICATIONS_1);
        MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1.add(MOCK_NOTIFICATIONS_4);

        MOCK_ALL_NOTIFICATIONS_FOR_CREATE = new ArrayList<>();
        MOCK_ALL_NOTIFICATIONS_FOR_CREATE.add(MOCK_NOTIFICATIONS_5);

    }

    // Test 1
    @Test
    public void getAllClientsNotificationsTest() {

        //SimpleJpaRepository<Object, Object> mockitoDao = null;
        //when(mockitoDao.findAll()).thenReturn(Collections.singletonList(MOCK_ALL_NOTIFICATIONS));
        when(mockitoDao.findAll()).thenReturn(MOCK_ALL_NOTIFICATIONS);
        //notificationsServiceimpl testUser = null;
        List<notifications> notificationsList = testUser.findall();

        assertIterableEquals(MOCK_ALL_NOTIFICATIONS, notificationsList);
        verify(mockitoDao).findAll();
    }

    // Test #2
    @Test
    public void getNotificationsByIdTest() {
        when(mockitoDao.findByClientId(1)).thenReturn(MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1);
        List<notifications> notificationsList = testUser.findallbyid(1);

        assertIterableEquals(MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1, notificationsList);
        verify(mockitoDao).findByClientId(1);
    }

    @Test
    public void createNewNotifications() {
        when(mockitoDao.save(MOCK_NOTIFICATIONS_5)).thenReturn(MOCK_NOTIFICATIONS_5);
        notifications test = testUser.create(MOCK_NOTIFICATIONS_5);

        assertEquals(MOCK_NOTIFICATIONS_5, test);
        verify(mockitoDao).save(MOCK_NOTIFICATIONS_5);
    }

    // Test #4
    @Test
    public void deleteNotificationsId() {

        int clientId = 2;

        willDoNothing().given(mockitoDao).deleteById(clientId);

        testUser.delete(clientId);

        verify(mockitoDao, times(1)).deleteById(clientId);
    }

    // Test #5
    @Test
    public void updateNotications() {
        when(mockitoDao.save(MOCK_NOTIFICATIONS_5)).thenReturn(MOCK_NOTIFICATIONS_5);
        notifications test = testUser.create(MOCK_NOTIFICATIONS_5);

        assertEquals(MOCK_NOTIFICATIONS_5, test);
        verify(mockitoDao).save(MOCK_NOTIFICATIONS_5);

    }

    // Test #6
    @Test
    public void getNotficationsByClientName()
    {
        when(mockitoDao.findByClientId(11)).thenReturn(MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1);
        List<notifications> notificationsList = testUser.findallbyid(11);

        assertIterableEquals(MOCK_ALL_NOTIFICATIONS_FOR_CLIENT_1, notificationsList);
        verify(mockitoDao).findByClientId(anyInt());

    }

}
