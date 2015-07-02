package redisgroovy

interface RedisConfig {
    def setEntity(String key, Object entity)

    def getEntity(Class<?> entityType, String key)
}