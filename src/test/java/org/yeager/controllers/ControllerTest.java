package org.yeager.controllers;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.yeager.models.Request;


import java.util.ArrayList;
import java.util.Random;

public class ControllerTest {

    private Controller target;

    private Random random;

    @Before
    public void setup() {
        target = new Controller();
        random = new Random();
    }

    @Test
    public void whenGetAllIsCalledWeShouldGetAList() {
        ResponseEntity responseEntity = target.getAll();
        Assert.assertEquals(responseEntity.getBody(), new ArrayList<Request>());
    }

    @Test
    public void whenGetIsCalledWeShouldGetASuccessResponse() {
        ResponseEntity actual = target.getById(random.nextInt());
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void whenCreateIsCalledWeShouldGetACreatedResponse() {
        ResponseEntity actual = target.create(new Request());
        Assert.assertEquals(HttpStatus.CREATED, actual.getStatusCode());
    }

    @Test
    public void whenDeleteIsCalledWeShouldGetASuccessResponse() {
        ResponseEntity actual = target.delete(random.nextInt());
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void whenUpdateIsCalledWeShouldGetASuccessResponse() {
        ResponseEntity actual = target.update(new Request(), random.nextInt());
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void whenCreateByIdIsCalledItShouldReturnMethodNotAllowed() {
        ResponseEntity responseEntity = target.createById(random.nextInt());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Test
    public void whenUpdateOrDeleteAllIsCalledItShouldReturnMethodNotAllowed() {
        ResponseEntity responseEntity = target.updateOrDeleteAll(new Request());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
