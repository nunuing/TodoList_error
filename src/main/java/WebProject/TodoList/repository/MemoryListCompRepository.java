package WebProject.TodoList.repository;

import WebProject.TodoList.domain.ListComp;

import java.util.*;

public class MemoryListCompRepository implements ListRepository{
    private static Map<Long, ListComp> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public ListComp save(ListComp comp) {
        comp.setNum(++sequence);
        store.put(comp.getNum(), comp);
        return comp;
    }

    @Override
    public Optional<ListComp> findByNum(Long num) {
        return Optional.ofNullable(store.get(num));
    }

    @Override
    public List<ListComp> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
