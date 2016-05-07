add task:
curl -X POST -d '{"taskName":"task","taskGroup":"test group","taskStatus":false,"cronExpression":"*********0","description":"test","beanClass":"Test","isConcurrent":false,"springId":"test","methodName":"test","param":"","paramType":"Map","paramDescription":"nothing"}' -H "Content-Type:application/json" http://localhost:8080/api/task

edit task:
curl -X POST -d '{"taskName":"mytask","taskGroup":"test group","taskStatus":false,"cronExpression":"*********0","description":"test","beanClass":"Test","isConcurrent":false,"springId":"test","methodName":"test","param":"","paramType":"Map","paramDescription":"nothing"}' -H "Content-Type:application/json" http://localhost:8080/api/task/29f4eb0e-2e1e-4380-a76d-0c2351c0c018

