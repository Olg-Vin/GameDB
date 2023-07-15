package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.models.Item;
import summerProject.demo.repositories.ItemRepository;
import summerProject.demo.services.ItemService;

import java.util.List;

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

    @Override
    public ItemDTO saveAndGet(ItemDTO itemDTO) {
        Item c = modelMapper.map(itemDTO, Item.class);
        return modelMapper.map(itemRepository.save(c), ItemDTO.class);
    }

    @Override
    public ItemDTO get(String s) {
        return modelMapper.map(itemRepository.findById(s), ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getAll() {
        return itemRepository.findAll().
                stream().map((s)->modelMapper.map(s, ItemDTO.class)).toList();
    }

    @Override
    public void update(ItemDTO itemDTO) {
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void delete(String s) {
        itemRepository.deleteById(s);
    }
}
