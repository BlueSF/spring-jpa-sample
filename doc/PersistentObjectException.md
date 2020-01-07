## detached entity passed to persist

```jvm
 Caused by: org.hibernate.PersistentObjectException: detached entity passed to persist: com.example.jpa.entity.Category
 	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:127)
 	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:118)
 	at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:726)
 	at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:694)
 	at org.hibernate.engine.spi.CascadingActions$7.cascade(CascadingActions.java:298)
 	at org.hibernate.engine.internal.Cascade.cascadeToOne(Cascade.java:492)
 	at org.hibernate.engine.internal.Cascade.cascadeAssociation(Cascade.java:416)
 	at org.hibernate.engine.internal.Cascade.cascadeProperty(Cascade.java:218)
 	at org.hibernate.engine.internal.Cascade.cascade(Cascade.java:151)
 	at org.hibernate.event.internal.AbstractSaveEventListener.cascadeBeforeSave(AbstractSaveEventListener.java:432)
 	at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:269)
 	at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:198)
 	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:128)
 	at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:192)
 	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:135)
 	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:118)
 	at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:726)
 	at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:694)
 	at org.hibernate.engine.spi.CascadingActions$7.cascade(CascadingActions.java:298)
 	at org.hibernate.engine.internal.Cascade.cascadeToOne(Cascade.java:492)
 	at org.hibernate.engine.internal.Cascade.cascadeAssociation(Cascade.java:416)
 	at org.hibernate.engine.internal.Cascade.cascadeProperty(Cascade.java:218)
 	at org.hibernate.engine.internal.Cascade.cascadeCollectionElements(Cascade.java:525)
 	at org.hibernate.engine.internal.Cascade.cascadeCollection(Cascade.java:456)
 	at org.hibernate.engine.internal.Cascade.cascadeAssociation(Cascade.java:419)
 	at org.hibernate.engine.internal.Cascade.cascadeProperty(Cascade.java:218)
 	at org.hibernate.engine.internal.Cascade.cascade(Cascade.java:151)
 	at org.hibernate.event.internal.AbstractSaveEventListener.cascadeAfterSave(AbstractSaveEventListener.java:464)
 	at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:298)
 	at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:198)
 	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:128)
 	at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:192)
 	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:135)
 	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:62)
 	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:108)
 	at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:702)
 	at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:688)
 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
 	at org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:314)
 	at com.sun.proxy.$Proxy86.persist(Unknown Source)
 	at org.springframework.data.jpa.repository.support.SimpleJpaRepository.save(SimpleJpaRepository.java:554)
 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
 	at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:371)
 	at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:204)
 	at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:657)
 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
 	at org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor.doInvoke(RepositoryFactorySupport.java:621)
 	at org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor.invoke(RepositoryFactorySupport.java:605)
 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
 	at org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:80)
 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
 	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:366)
 	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)
 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
 	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:139)
 	... 96 more
```

종속성 관계 오류. cascadeType.ALL 을 지워 주고 각각을 따로 저장 한다.

new 연산자로 entity 를 객체화 할 경우 해당 객체는 일시적이며 hibernate session 과 연관이 없다.

따라서 데이터베이스에도 식별자 값도 없고 저장도 안되어있다. hibernate session 을 사용하여 해당 객체에 대한 지속성을 가지게 해야한다...


CascadeType의 종류에는 다음과 같은 것들이 있다.

CascadeType.RESIST – 엔티티를 생성하고, 연관 엔티티를 추가하였을 때 persist() 를 수행하면 연관 엔티티도 함께 persist()가 수행된다.  만약 연관 엔티티가 DB에 등록된 키값을 가지고 있다면 detached entity passed to persist Exception이 발생한다.
CascadeType.MERGE – 트랜잭션이 종료되고 detach 상태에서 연관 엔티티를 추가하거나 변경된 이후에 부모 엔티티가 merge()를 수행하게 되면 변경사항이 적용된다.(연관 엔티티의 추가 및 수정 모두 반영됨)
CascadeType.REMOVE – 삭제 시 연관된 엔티티도 같이 삭제됨
CascadeType.DETACH – 부모 엔티티가 detach()를 수행하게 되면, 연관된 엔티티도 detach() 상태가 되어 변경사항이 반영되지 않는다.
CascadeType.ALL – 모든 Cascade 적용


