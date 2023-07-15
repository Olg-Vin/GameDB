package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.models.Item;
import summerProject.demo.repositories.ItemRepository;
import summerProject.demo.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService<String> {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(ItemDTO itemDTO) {
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

}
