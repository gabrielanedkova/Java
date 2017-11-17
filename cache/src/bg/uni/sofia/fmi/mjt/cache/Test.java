package bg.uni.sofia.fmi.mjt.cache;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) throws CapacityExceededException {

		Cache<Integer, String> cache = new MemCache<Integer, String>();
		cache.set(1, "a", null);
		cache.get(9);
		CapacityExceededException capacityExceededException = new CapacityExceededException("");
		System.out.println(capacityExceededException.getMessage());
		 System.out.println(cache.getHitRate());
		
	}

}
