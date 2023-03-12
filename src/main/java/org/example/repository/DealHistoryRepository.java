package org.example.repository;

import lombok.NonNull;
import org.example.entity.Deal;

public interface DealHistoryRepository {
    Deal save(@NonNull Deal deal);

}
