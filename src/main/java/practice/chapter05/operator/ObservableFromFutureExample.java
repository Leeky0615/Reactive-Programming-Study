package practice.chapter05.operator;

import practice.chapter05.ServiceCenter;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ObservableFromFutureExample {
    public static void main(String[] args) {
        ServiceCenter center = new ServiceCenter();
        System.out.println("--------- Sync --------");
        syncOperate(center);
        System.out.println("--------- Async --------");
        asyncOperateByFuture(center);
    }

    private static void syncOperate(ServiceCenter center) {
        long start = System.currentTimeMillis();
        // 주문 견적
        int itemRepairCost = center.getItemRepairCostSync(3);
        Logger.log(LogType.PRINT, "# (1) 제품 수리비 계산 완료");
        Logger.log(LogType.PRINT, "# 제품 수리비는 " + itemRepairCost + "원 입니다.");

        // 가동 중단 신청
        requestStopFactory();

        // 보험 접수
        requestInsurance();
        long end = System.currentTimeMillis();
        double executeTime = (end - start) / 1000.0;
        System.out.println("\n# 처리 시간: " + executeTime + "초");
    }

    private static void asyncOperateByFuture(ServiceCenter center) {
        long start = System.currentTimeMillis();

        // 주문 견적
        Future<Integer> future = center.getItemRepairCostAsync(3);
        // 가동 중단 신청
        requestStopFactory();
        // 보험 접수
        requestInsurance();

        try {
            int itemRepairCost = future.get();
            Logger.log(LogType.PRINT, "# (1) 제품 수리비 계산 완료");
            Logger.log(LogType.PRINT, "# 제품 수리비는 " + itemRepairCost + "원 입니다.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        double executeTime = (end - start) / 1000.0;
        System.out.println("\n# 처리 시간: " + executeTime + "초");
    }

    private static void requestStopFactory() {
        try {
            Thread.sleep(1000);
            Logger.log(LogType.PRINT, "# (2) 가동 중단 신청이 완료되었습니다.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void requestInsurance() {
        try {
            Thread.sleep(1000);
            Logger.log(LogType.PRINT, "# (3) 보험 접수가 완료되었습니다.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
