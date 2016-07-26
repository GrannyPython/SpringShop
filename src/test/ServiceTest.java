import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ts.model.Cart;
import org.ts.model.Parameter;
import org.ts.repository.ParameterRepository;
import org.ts.service.CartService;
import org.ts.service.ParameterService;

import java.util.List;
import java.util.Set;


public class ServiceTest {
    @Autowired
    CartService cartService;
    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    ParameterService parameterService;

    @Test(expected = NullPointerException.class)
    public void test1() {
        Cart cart = new Cart();
        cartService.save(cart);
    }


    @Test(expected = NullPointerException.class)
    public void test3() {
        Parameter parameter = new Parameter();
        parameterService.save(parameter);
    }

}

