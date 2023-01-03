package practice.chapter05;

import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ServiceCenter {

    public int getItemRepairCostSync(int items) {
        return calculateItemRepair(items);
    }

    public Future<Integer> getItemRepairCostAsync(int items) {
        return CompletableFuture.supplyAsync(() -> calculateItemRepair(items));
    }

    private int calculateItemRepair(int items) {
        Logger.log(LogType.PRINT, "# 장비 수리비 계산 중...");
        delay();
        return items * 20000;
    }

    private void delay() {
        TimeUtil.sleep(3000);
    }
}
