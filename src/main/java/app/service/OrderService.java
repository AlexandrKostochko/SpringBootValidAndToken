package app.service;

import app.model.Order;
import app.model.Pet;
import app.model.PetStatus;
import app.repository.OrderRepository;
import app.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static app.model.PetStatus.*;

//@Service - почему такая аннотация?
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PetRepository petRepository;

//    private List<Order> orderList = new ArrayList<>();
//    private static long orderId = 1;
//
//    @Autowired
//    private PetService petService;
//
//    public void addOrder (Order order) {
//        order.setId(orderId);
//        orderList.add(order);
//        orderId++;
//    }

//    public List<Order> getOrderList () {
//        return orderList;
//    }

//    public Order getOrderById (long id) {
//        for (Order order: orderList) {
//            if (order.getId() ==  id) {
//                return order;
//            }
//        }
//        return null;
//    }
//
//    public boolean deleteOrderById (long id) {
//        for (Order order: orderList) {
//            if (order.getId() ==  id) {
//                orderList.remove(order);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Map<PetStatus, Integer> getQuantityStatus () {
//        Map<PetStatus, Integer> statusList = new HashMap<>();
//        List<Pet> petList = petService.getPets();
//        int availableCounter = 0;
//        int pendingCounter = 0;
//        int soldCounter = 0;
//        for (Pet currentPet : petList
//             ) {
//            switch (currentPet.getPetStatus()) {
//                case AVAILABLE:
//                    availableCounter++;
//                    break;
//                case SOLD:
//                    pendingCounter++;
//                    break;
//                case PENDING:
//                    pendingCounter++;
//                    break;
//                default: return null;
//            }
//        }
//        statusList.put(AVAILABLE, availableCounter);
//        statusList.put(PENDING, pendingCounter);
//        statusList.put(SOLD, soldCounter);
//        return statusList;
//    }

    public Map<PetStatus, Integer> getQuantityStatus(List<Pet> pets) {
        Map<PetStatus, Integer> map = new HashMap<>();
        for (Pet pet : pets) {
            map.put(pet.getPetStatus(), map.getOrDefault(pet.getPetStatus(), 0) + 1);
        }
        return map;
    }


    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Optional<Order> getOrderById (long id) {
        return orderRepository.findById(id);
    }

    public boolean deleteOrderById (long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    public Map<PetStatus, Integer> getQuantityStatus () {
//        Map<PetStatus, Integer> map = new HashMap<>();
//
//    }
}