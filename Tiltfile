SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='registry.perfect300rock.com/tapdev/spring-cloud-config-server-source')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='workloads')

k8s_custom_deploy(
    'spring-cloud-config-server',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --live-update" +
              " --local-path " + LOCAL_PATH +
              " --source-image " + SOURCE_IMAGE +
              " --namespace " + NAMESPACE +
              " --yes >/dev/null" +
              " && kubectl get workload spring-cloud-config-server --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('spring-cloud-config-server', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'spring-cloud-config-server'}])
